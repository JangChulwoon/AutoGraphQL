package org.toy.til.refactoring.ch01

class Customer {
    String name
    Vector rentals = new Vector();

    Customer(String name) {
        this.name = name
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String statement() {
        double totalAmount = 0
        int frequentRenterPoints = 0
        Enumeration rentals = rentals.elements()
        String result = getName() + "고객님의 대여 기록 \n"

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement()

            // 비디오 종류별 대여료 계산
            double thisAmount = each.getCharge(each)
            // 적립 포인트 1 증가
            frequentRenterPoints++

            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++
            }

            // 이번에 대여하는 비디오 정보와 대여료 출력
            result += "/t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n"

            // 현재까지 누적된 총 대여료
            totalAmount += thisAmount
        }
    }


}

