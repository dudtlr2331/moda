package com.moda.moda.order;

import com.moda.moda.member.MemberVO;
import com.moda.moda.member.service.MemberService;
import com.moda.moda.order.service.OrderService;
import com.moda.moda.product.ProdVO;
import com.moda.moda.product.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.moda.cmm.OrderNumberGenerator.generateOrderNumber;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final ProdService prodService;
    private final MemberService memberService;

    @Autowired
    public OrderController(OrderService orderService, ProdService prodService, MemberService memberService) {
        this.orderService = orderService;
        this.prodService = prodService;
        this.memberService = memberService;
    }

    // 주문
    @RequestMapping("/order/order.do")
    public String order(Model model, OrderVO pvo, HttpSession session) {
        String uId = (String) session.getAttribute("uId");
        String optionInfo[] = {pvo.getColorOption(), pvo.getSizeOption()};

        ProdVO detail = prodService.selectProdOne(pvo.getProdCode());
        List<OrderVO> orderList = orderService.selectOrdList(pvo);

        // 세션에서 로그인 정보 가져오기
        MemberVO loginInfo = memberService.findByMember(uId);

        // 로그인 정보를 모델에 추가
        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("optionInfo", optionInfo);
        model.addAttribute("detail", detail);
        model.addAttribute("orderList", orderList);

        session.removeAttribute("QTY");

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
    public String orderCartList() {
        return "html/moda/order/order_cart";
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

    //장바구니 리스트
    @RequestMapping("/order/orderCartListAjax.do")
    @ResponseBody
    public Map<String, Object> orderCartListAjax(HttpServletRequest req, HttpServletResponse res, OrderVO pvo) {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> jArry = new ArrayList<>();

        // 세션에서 로그인 정보 가져오기
        HttpSession session = req.getSession();
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        pvo.setUsrId(loginInfo.getUId());

        List<OrderVO> cartList = orderService.selectCartList(pvo);

        for (OrderVO order : cartList) {
            Map<String, Object> obj = new HashMap<>();
            obj.put("cartNum", order.getCartNum());
            obj.put("usrId", order.getUsrId());
            obj.put("prodQty", order.getProdQty());
            obj.put("prodImg", order.getProdImg());
            obj.put("prodImgDtl", order.getProdImgDtl());
            obj.put("cartAmount", order.getCartAmount());
            obj.put("prodCode", order.getProdCode());
            obj.put("prodPrice", order.getProdPrice());
            obj.put("prodDesc", order.getProdDesc());
            jArry.add(obj);
        }

        data.put("result", "success");
        data.put("data", jArry);

        return data;
    }

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
