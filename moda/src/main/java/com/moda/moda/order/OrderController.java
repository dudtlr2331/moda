package com.moda.moda.order;

import com.moda.moda.member.MemberVO;
import com.moda.moda.order.service.OrderService;
import com.moda.moda.product.ProdVO;
import com.moda.moda.product.service.ProdService;
import com.moda.moda.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.moda.cmm.OrderNumberGenerator.generateOrderNumber;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ProdService prodService;

    @Autowired
    public OrderController(OrderService orderService, ProdService prodService) {
        this.orderService = orderService;
        this.prodService = prodService;
    }

    // 주문
    @RequestMapping("/order/order.do")
    public String order(Model model, OrderVO pvo, HttpSession session) {
        String optionInfo[] = {pvo.getColorOption(), pvo.getSizeOption()};

        ProdVO detail = prodService.selectProdOne(pvo.getProdCode());
        List<OrderVO> orderList = orderService.selectOrdList(pvo);

        // 세션에서 로그인 정보 가져오기
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");

        // 로그인 정보를 모델에 추가
        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("optionInfo", optionInfo);
        model.addAttribute("detail", detail);
        model.addAttribute("orderList", orderList);

        return "html/moda/order/order";
    }

    //주문 생성
    @RequestMapping("/order/orderRegister.do")
    public String orderRegister(OrderVO pvo, Model model) {
        pvo.setOrdNo(generateOrderNumber());
        orderService.insertOrd(pvo);
        orderService.insertOrdDtl(pvo);

        OrderVO orderOne = orderService.selectOrdOne(pvo);
        OrderVO orderDtlOne = orderService.selectOrdDtlOne(pvo);

        model.addAttribute("orderOne",orderOne);
        model.addAttribute("orderDtlOne",orderDtlOne);
        return "html/moda/order/order_confirm";
    }

    //주문 리스트
//    @RequestMapping("/order/orderList.do")
//    public String orderList(HttpServletRequest req, HttpServletResponse res) {
//        OrderVO pvo = new OrderVO();
//        List<OrderVO> orderList = orderService.selectOrdList(pvo);
//        req.setAttribute("orderList", orderList);
//        return "shp/order/order_list";
//    }

    //카트 리스트
    @RequestMapping("/order/orderCartList.do")
    public String orderCartList(HttpServletRequest req, HttpServletResponse res) {
        //공통 코드 가져오기
        CateVO cateVO = new CateVO();
        List<CateVO> oneDepthCateList = cateService.selectCateList(cateVO);
        req.setAttribute("oneDepthCateList", oneDepthCateList);

        return "shp/order/order_cart";
    }

    //장바구니 구매
//    @RequestMapping("/order/orderCartRegister.do")
//    public String orderCartRegister(HttpServletRequest req, HttpServletResponse res, OrderVO pvo) {
//        String seq = pvo.getCheckedList();
//        String key = seq.substring(0, seq.length() - 1);
//        pvo.setKey(key);
//
//        String[] ordBasketSeq = key.split(",");
//        List<OrderVO> detail = new ArrayList<OrderVO>();
//
//        for(int i = 0; i < ordBasketSeq.length; i++) {
//            pvo.setOrdBasketSeq(Long.parseLong(ordBasketSeq[i]));
//            detail.add(orderService.ordBasketSelect(pvo));
//        }
//
////		List<OrderVO> detail = orderService.ordBasketSelect(pvo);
//        Long totalPayment = (long) (detail.get(0).getDlvPrc());
//        Long totalDlvPrc = (long) (detail.get(0).getDlvPrc());
//        Long totalGoodsPrc = 0L;
//
//        for (int i = 0; i < detail.size(); i++) {
//            totalPayment += (long) (detail.get(i).getGoodsPrc() - detail.get(i).getGoodsSalePrc());
//            totalGoodsPrc += (long) (detail.get(i).getGoodsPrc() - detail.get(i).getGoodsSalePrc());
//        }
//
//        req.setAttribute("detail", detail);
//        req.setAttribute("totalPayment", totalPayment);
//        req.setAttribute("totalDlvPrc", totalDlvPrc);
//        req.setAttribute("totalGoodsPrc", totalGoodsPrc);
//        req.setAttribute("key", key);
//
//        return "shp/order/order_basket";
//    }
//
//    //장바구니 구매 액션 (주문테이블에 넣기)order_cart_register_act
//    @RequestMapping("/order/orderCartRegisterAct.do")
//    public String orderCartRegisterAct(HttpServletRequest req, HttpServletResponse res, OrderVO pvo) {
//        HttpSession session = req.getSession();
//        UserVO loginVo = (UserVO) session.getAttribute("loginInfo");
//
//        String seq = pvo.getCheckedList();
//        String goodsNm = pvo.getGoodsNm();
//        String[] seqs = seq.split(",");
//        String[] goodsNmArry = goodsNm.split(",");
//
//        pvo.setOrdNo(OrdUtil.getPinNo());
//        pvo.setUsrId(loginVo.getUsrId());
//        pvo.setRgstId(loginVo.getUsrId());
//        pvo.setUpdtId(loginVo.getUsrId());
//        pvo.setOrdrId(loginVo.getUsrId());
//        pvo.setPrclWay("");
//        pvo.setPackWay("");
//        pvo.setBillNum((long) 0);
//        pvo.setOrdStat("02"); //주문 상태 - 결제 완료
//        pvo.setSaleBoardSeq(Long.parseLong(seqs[0]));
//        pvo.setGoodsNmArry(goodsNmArry);
//
//        for(int i = 0; i < seqs.length; i++) {
//            //묶음 주문하면 리뷰를 1건밖에 못쓴다...
//            if(null != pvo.getSaleBoardSeqs() && null != pvo.getSaleBoardSeqs()[i] && !"".equals(pvo.getSaleBoardSeqs()[i])) {
//                pvo.setSaleBoardSeq(Long.parseLong(pvo.getSaleBoardSeqs()[i]));
//                pvo.setIndex(i);
//            }
//            orderService.insertCartOrdDtl(pvo);
//            if(i == 0) {
//                orderService.insertOrd(pvo);
//            }
//        }
//
//        for(int i = 0; i < seqs.length; i++) {
//            pvo.setOrdBasketSeq(Long.parseLong(seqs[i]));
//            orderService.updateBasket(pvo);
//        }
//        OrderVO orderOne = orderService.selectOrdOne(pvo);
//        List<OrderVO> orderDtlOne = orderService.selectCartOrdDtlList(pvo);
//
//        req.setAttribute("orderOne", orderOne);
//        req.setAttribute("orderDtlOne", orderDtlOne);
//
//        return "shp/order/order_basket_confirm";
//    }
//
//    //장바구니 리스트
//    @RequestMapping("/order/orderCartListAjax.do")
//    @ResponseBody
//    public JSONObject orderCartListAjax(HttpServletRequest req, HttpServletResponse res, OrderVO pvo) {
//        JSONObject data = new JSONObject();
//        JSONArray jArry = new JSONArray();
//
//        HttpSession session = req.getSession();
//        UserVO loginVo = (UserVO) session.getAttribute("loginInfo");
//        pvo.setUsrId(loginVo.getUsrId());
//        List<OrderVO> basketList = orderService.selectBasketList(pvo);
//
//        for(int i=0; i<basketList.size(); i++) {
//            JSONObject obj = new JSONObject();
//            obj.put("ordBasketSeq", basketList.get(i).getOrdBasketSeq());
//            obj.put("usrId", basketList.get(i).getUsrId());
//            obj.put("goodsQty", basketList.get(i).getGoodsQty());
//            obj.put("saleBoardSeq", basketList.get(i).getSaleBoardSeq());
//            obj.put("imgPath", basketList.get(i).getImgPath());
//            obj.put("imgNm", basketList.get(i).getImgNm());
//            obj.put("bulTitNm", basketList.get(i).getBulTitNm());
//            obj.put("goodsCd", basketList.get(i).getGoodsCd());
//            obj.put("entrNo", basketList.get(i).getEntrNo());
//            obj.put("goodsPrc", basketList.get(i).getGoodsPrc());
//            obj.put("goodsSalePrc", basketList.get(i).getGoodsSalePrc());
//            obj.put("saleCnt", basketList.get(i).getSaleCnt());
//            obj.put("saleStatCd", basketList.get(i).getSaleStatCd());
//            obj.put("description", basketList.get(i).getDescription());
//            jArry.add(obj);
//        }
//
//        data.put("result", "success");
//        data.put("dataList", jArry);
//
//        return data;
//    }
//
//    //장바구니 담기
//    @RequestMapping("/order/orderCartInsertAjax.do")
//    @ResponseBody
//    public JSONObject orderCartInsertAjax(HttpServletRequest req, HttpServletResponse res, OrderVO pvo) {
//        JSONObject data = new JSONObject();
//
//        HttpSession session = req.getSession();
//        UserVO loginVo = (UserVO) session.getAttribute("loginInfo");
//
//        SalesVO pSaleVO = new SalesVO();
//        pSaleVO.setSaleBoardSeq(Long.parseLong(req.getParameter("searchSaleBoardSeq")));
//
//        SalesVO saleVO = salesService.selectSalesOne(pSaleVO);
//
//        pvo.setGoodsCd(Long.parseLong(String.valueOf(saleVO.getGoodsCd())));
//        pvo.setEntrNo(saleVO.getEntrNo());
//        pvo.setSaleBoardSeq(pSaleVO.getSaleBoardSeq()); //saleBoardSeq
//        pvo.setUsrId(loginVo.getUsrId());
//
//        if(pvo.getGoodsQty() == 0) {
//            pvo.setGoodsQty(1);
//        }
//
//        int result = orderService.insertBasket(pvo);
//
//        data.put("result", "success");
//
//        return data;
//    }
//
//    //장바구니 삭제
//    @RequestMapping("/order/orderCartDeleteAjax.do")
//    @ResponseBody
//    public JSONObject orderCartDeleteAjax(HttpServletRequest req, HttpServletResponse res, OrderVO pvo) {
//        JSONObject data = new JSONObject();
//
//        String seq = pvo.getCheckedList();
//        String[] seqs = seq.split(",");
//        int result = 0;
//
//        for(int i = 0; i < seqs.length; i++) {
//            pvo.setOrdBasketSeq(Long.parseLong(seqs[i]));
//            result = orderService.deleteBasket(pvo);
//        }
//
//        data.put("result", "success");
//
//        return data;
//    }
}
