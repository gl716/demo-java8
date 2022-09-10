package com.leon.enumtest;

public enum ColorEn {
    RED(1){
        @Override
        public String getDesc(){
            return "1";
        }
    }, GREEN(2){
        @Override
        public String getDesc(){
            return "2";
        }
    };

    int code;
    String desc;
    ColorEn(int code){
        this.code = code;
    }

    int getCode(){
        return this.code;
    }

    abstract String getDesc();

}
