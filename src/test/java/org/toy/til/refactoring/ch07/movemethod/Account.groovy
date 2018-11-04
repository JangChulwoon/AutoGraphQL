package org.toy.til.refactoring.ch07.movemethod

class Account {

    AccountType type
    def daysOverdrawn

    // 이걸 굳이 리팩토링해야하는지 모르겠어. 예시가 ...
    // 한번만 호출하는데 ?
    double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85
            }
            return result
        } else {
            return daysOverdrawn * 1.75
        }
    }

    double bankCharge() {
        double result = 4.5
        if (daysOverdrawn > 0) {
            result += overdraftCharge()
        }
        return result
    }
}
