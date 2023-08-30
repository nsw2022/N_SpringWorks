package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.ReservationData;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class ReservationController {

    @GetMapping("reservation")
    public String showReservationForm(ReservationData reservationData) {
        
        return "reservationForm";
    }

    @PostMapping("/reservation")
    public String processReservationForm(
    		@Valid @ModelAttribute("reservationData") ReservationData reservationData,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "reservationForm";
        }

        // 예약 정보를 처리하는 로직을 여기에 추가할 수 있습니다.

        return "reservationConfirmation";
    }
}
