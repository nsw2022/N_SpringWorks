package aaa.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReservationData {

    @NotEmpty(message = "지점명을 입력하세요.")
    private String branchName;

    @NotEmpty(message = "호실명을 입력하세요.")
    private String roomName;

    @NotEmpty(message = "예약일을 선택하세요.")
    private String reservationDate;

    @NotEmpty(message = "예약 시간을 선택하세요.")
    private String reservationTime;

    @NotEmpty(message = "예약자 성함을 입력하세요.")
    private String guestName;

    @NotEmpty(message = "전화번호를 입력하세요.")
    private String phoneNumber;

    // 추가 필드 및 유효성 검사 규칙을 여기에 추가할 수 있습니다.
}