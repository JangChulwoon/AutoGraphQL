package org.toy.til.refactoring.ch08;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IntervalWindow extends Frame {

    private TextField startField;
    private TextField endField;
    private TextField lengthField;

    class SymFocus extends FocusAdapter {

        public void focusLost(FocusEvent event) {
            Object object = event.getSource();
            if (object == startField) {
                // startFieldFocusLost(event);
            } else if (object == endField) {
                // endFieldFocusLost(event);
            } else if (object == lengthField) {
                //endFieldFocusLost(event);
            }
        }

        public void startFieldFocusLost(Event event) {
           /* if(isNotInteger()){
                set 0
            }
           */
            calculateEnd();
        }

        // !!  warning
        public void calculateEnd() {
            // business logic
        }
    }


}
