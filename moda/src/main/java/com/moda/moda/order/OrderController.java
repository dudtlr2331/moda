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
//    @RequestMapping("/order/orderRegister.do")
//    public String orderRegister(HttpServletRequest req, HttpServletResponse res, OrderVO pvo) {
//        HttpSession session = req.getSession();
//        UserVO loginVo = (UserVO) session.getAttribute("loginInfo");
//
//        pvo.setOrdStat("02"); //주문 상태 - 결제 완료
//        pvo.setOrdNo(OrdUtil.getPinNo());
//        pvo.setUsrId(loginVo.getUsrId());
//        pvo.setRgstId(loginVo.getUsrId());
//        pvo.setUpdtId(loginVo.getUsrId());
//        pvo.setOrdrId(loginVo.getUsrId());
//        pvo.setPrclWay("");
//        pvo.setPackWay("");
//        pvo.setBillNum((long) 0);
//
//        orderService.insertOrd(pvo);
//        orderService.insertOrdDtl(pvo);
//
//        OrderVO orderOne = orderService.selectOrdOne(pvo);
//        OrderVO orderDtlOne = orderService.selectOrdDtlOne(pvo);
//
//        req.setAttribute("orderOne", orderOne);
//        req.setAttribute("orderDtlOne", orderDtlOne);
//
//        return "shp/order/order_confirm";
//    }

    //주문 리스트
//    @RequestMapping("/order/orderList.do")
//    public String orderList(HttpServletRequest req, HttpServletResponse res) {
//        OrderVO pvo = new OrderVO();
//        List<OrderVO> orderList = orderService.selectOrdList(pvo);
//        req.setAttribute("orderList", orderList);
//        return "shp/order/order_list";
//    }
}
