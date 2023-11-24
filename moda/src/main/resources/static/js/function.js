/**
 * 문자열의 마지막(끝) 문자의 종성 포함 여부 확인
 * @param value - Target String
 * @returns 종성 포함 여부
 */
function hasCoda(value) {
    return ((value.charCodeAt(value.length - 1) - 0xAC00) % 28) > 0;
}


/**
 * 필드(Elemenet) 유효성 검사
 * @param target - 검사 대상 Element
 * @param fieldName - 필드명
 * @param focusTarget - 포커스 대상 Element
 * @returns 필드 입력(선택) 여부
 */
function isValid(target, fieldName, focusTarget) {
    if (target.value.trim()) {
        return true;
    }

    const particle = (hasCoda(fieldName)) ? '을' : '를'; // 조사
    const elementType = (target.type === 'text' || target.type === 'password' || target.type === 'search' || target.type === 'textarea') ? '입력' : '선택';
    alert( `${fieldName + particle} ${elementType}해 주세요.` );

    target.value = '';
    ( !focusTarget ? target : focusTarget).focus();
    throw new Error(`"${target.id}" is required...`)
}

/**
 * 데이터 조회
 * @param uri - API Request URI
 * @param params - Parameters
 * @returns json - 결과 데이터
 */
function getJson(uri, params) {

    let json = {}

    $.ajax({
        url : uri,
        type : 'get',
        dataType : 'json',
        data : params,
        async : false,
        success : function (response) {
            json = response;
        },
        error : function (request, status, error) {
            console.log(error)
        }
    })

    return json;
}


/**
 * 데이터 저장/수정/삭제
 * @param uri - API Request URI
 * @param method - API Request Method
 * @param params - Parameters
 * @returns json - 결과 데이터
 */
function callApi(uri, method, params) {

    let json = {}

    $.ajax({
        url : uri,
        type : method,
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        data : (params) ? JSON.stringify(params) : {},
        async : false,
        success : function (response) {
            json = response;
        },
        error : function (request, status, error) {
            console.log(error)
        }
    })

    return json;
}

function fn_ajax(obj){
    let url = obj.url;
    let method = obj.method;
    let params = obj.params;
    let fn_success = obj.success;

    let httpRequest = new XMLHttpRequest();
    if(!httpRequest) {
        alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
        return false;
    }
    httpRequest.onreadystatechange = ()=>{
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
                let res = httpRequest.responseText;
                fn_success(JSON.parse(res));
            } else {
                console.log(`code: ${httpRequest.status}`);
                console.log(`message: ${httpRequest.responseText}`);
                alert('request에 뭔가 문제가 있어요.');
            }
        }
    };
    httpRequest.open(method, url);
    /* httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); */
    if(method == 'get' || method =='GET'){
        httpRequest.send();
    }else{
        httpRequest.setRequestHeader('Content-Type', 'application/json');
        httpRequest.send(params);
    }
}