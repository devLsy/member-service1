package study.memberservice1.controller;

import study.memberservice1.domain.dto.*;
import study.memberservice1.domain.vo.OrderResultVO;
import study.memberservice1.domain.vo.OrderVO;
import study.memberservice1.service.BookService;
import study.memberservice1.service.MemberService;
import study.memberservice1.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final MemberService memberService;
    private final BookService bookService;
    private final OrderService orderService;

    /**
     * 주문 폼
     */
    @GetMapping("/order/new")
    public String order(Model model) {
        List<MemberDto> members = memberService.findAll(new MemberSearchDto());
        List<BookDto> books = bookService.findAll();
        model.addAttribute("members", members);
        model.addAttribute("books", books);
        return "order/orderForm";
    }

    /**
     * 주문
     * @param memberId
     * @param bookId
     * @param count
     * @return
     */
    @PostMapping("/order/new")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("bookId") Long bookId,
                        @RequestParam("count") int count) {

        OrderVO orderVO = OrderVO.createOrder(memberId);
        orderService.createOrder(orderVO, bookId, count);
        return "redirect:/orders";
    }

    /**
     * 주문 목록
     * @param orderSearchDto
     * @param model
     * @return
     */
    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch")OrderSearchDto orderSearchDto, Model model) {
        List<OrderResultVO> orders = orderService.findAllOrder(orderSearchDto);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    /**
     * 주문 취소
     * @param orderId
     * @return
     */
    @PostMapping("/order/{orderId}/cancel")
    public String orderCancel(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
