package com.atguigu.team.domain;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/28 - 09 - 28
 * @Description: com.atguigu.team.domain
 */
public class PC implements Equipment{

        private String model; // 机器类型
        private String display; // 显示器名称

        public String getModel() {
                return model;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public String getDisplay() {
                return display;
        }

        public void setDisplay(String display) {
                this.display = display;
        }

        public PC(String model, String display) {
                this.model = model;
                this.display = display;
        }

        public PC() {
        }

        @Override
        public String getDescription() {
                return "model = " + model + ", display = " + display;
        }

}
