package com.atguigu.team.domain;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/28 - 09 - 28
 * @Description: com.atguigu.team.domain
 */
public class NoteBook implements Equipment{


        private String model;
        private double price;

        public NoteBook() {
        }

        public NoteBook(String model, double price) {
            this.model = model;
            this.price = price;
        }


    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
