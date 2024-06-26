package com.ssafy.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.ArrayList;

@Controller
public class SocketController {

    // /receive를 메시지를 받을 endpoint로 설정합니다.
    @MessageMapping("/receive")
    
    // /send로 메시지를 반환합니다.
    @SendTo("/send")
    // SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
    // 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
    public List<SocketVO> SocketHandler(List<SocketVO> socketVOList) {
        // 여기서 socketVOList를 처리하는 로직을 작성합니다.
        List<SocketVO> resultList = new ArrayList<>();
        for(SocketVO socketVO : socketVOList) {
            int planIdx = socketVO.getPlanIdx();
            int scheduleIdx = socketVO.getScheduleIdx();
            double scheduleLat = socketVO.getScheduleLat();
            double scheduleLon = socketVO.getScheduleLon();
            String scheduleLocation = socketVO.getScheduleLocation();
            String scheduleMemo = socketVO.getScheduleMemo();
            int scheduleOrder = socketVO.getScheduleOrder();

            // 생성자로 반환값을 생성합니다.
            SocketVO result = new SocketVO(planIdx, scheduleIdx, scheduleLat, scheduleLon, scheduleLocation, scheduleMemo, scheduleOrder);
            resultList.add(result);
        }
        
        // 처리한 결과를 반환합니다.
        return resultList;
    }
}
