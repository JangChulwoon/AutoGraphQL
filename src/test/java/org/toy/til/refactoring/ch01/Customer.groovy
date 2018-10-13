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
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement()

            // 비디오 종류별 대여료 계산
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 15
                    }
                    break
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3
                    break
                case Movie.CHILD_RENS:
                    thisAmount += 1.5
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5
                    }
                    break;
            }
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

