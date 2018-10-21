package org.toy.til.refactoring.ch01

class Customer {
    String name
    Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String statement() {
        Enumeration rentals = rentals.elements()
        String result = getName() + "고객님의 대여 기록 \n"

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement()

            // 이번에 대여하는 비디오 정보와 대여료 출력
            result += each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n"

        }
        result += "누적 대여료: " + String.valueOf(getTotalAmount()) + "\n"
        result += "적립 포인트: " + String.valueOf(getFrequentRenterPoints())
        return result
    }

    double getTotalAmount() {
        double totalAmount = 0;
        Enumeration rentals = rentals.elements()
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement()

            // 현재까지 누적된 총 대여료
            totalAmount += each.getCharge()

        }
        return totalAmount
    }

    double getFrequentRenterPoints() {
        double frequentRenterPoints = 0;
        Enumeration rentals = rentals.elements()
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement()

            frequentRenterPoints += each.getPoints()

        }
        return frequentRenterPoints
    }


}

