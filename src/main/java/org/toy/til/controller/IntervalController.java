package org.toy.til.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// refactoring 8장의 예제를 작성하기 위함.
// Frame 을 controller 로 변경
@RestController
@RequestMapping("event")
public class IntervalController {

    @GetMapping("/focusLeave/{type}")
    public String focusLeave(@PathVariable(required = false) int type) {
        FocusType focusType = FocusType.find(type);
        if (FocusType.START.equals(focusType)) {
            return "remove focus of start point.";
        } else if (FocusType.END.equals(focusType)) {
            return "remove focus of end point.";
        } else if (FocusType.LENGTH.equals(focusType)) {
            return "remove focus of length point.";
        }
        return FocusType.NONE.name();
    }

    enum FocusType {
        START(1), END(2), LENGTH(3), NONE(0);

        private int type;

        FocusType(int type) {
            this.type = type;
        }

        public static FocusType find(int type) {
            for (FocusType focusType : FocusType.values()) {
                if (focusType.getType() == type) {
                    return focusType;
                }
            }
            throw new IllegalArgumentException("Illegal type : " + type);
        }

        public int getType() {
            return type;
        }
    }
}
