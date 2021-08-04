package com.jong.day6;

class Tesla implements ICar {

    @Override
    public void getModel() {
        System.out.println("zapdos");

    }

    @Override
    public void getColor() {
        System.out.println("yellow");

    }

    static class Ferrari implements ICar {

        @Override
        public void getModel() {
            System.out.println("fastcar");
        }

        @Override
        public void getColor() {
            System.out.println("pink");

        }
    }

    static class CarFactory {
        public static ICar getCarInstance(int id) {
            switch (id) {
                case 1:
                    return new Ferrari();

                case 2:
                    return new Tesla();
                default:
                    return null;
            }
        }
    }

    public static class Demo6 {
        public static void main(String[] args) {

        }
    }
}

