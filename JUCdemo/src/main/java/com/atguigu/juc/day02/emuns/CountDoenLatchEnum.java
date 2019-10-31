package com.atguigu.juc.day02.emuns;

public enum CountDoenLatchEnum {

    ONE(1,"单杀"),
    TWO(2,"双杀"),
    THREE(3,"三杀"),
    FOUT(4,"四杀"),
    FIVE(5,"五杀") ;

    private int code;
    private String messige;

    CountDoenLatchEnum(int code, String messige) {
        this.code = code;
        this.messige = messige;
    }

    public int getCode() {
        return code;
    }

    public String getMessige() {
        return messige;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessige(String messige) {
        this.messige = messige;
    }

    @Override
    public String toString() {
        return "CountDoenLatchEnum{" +
                "code=" + code +
                ", messige='" + messige + '\'' +
                '}';
    }

    public static CountDoenLatchEnum getEnum(int index){
        CountDoenLatchEnum[] values = CountDoenLatchEnum.values();

        for (CountDoenLatchEnum anEnum : values) {
            if (anEnum.getCode() == index) {
                return anEnum;
            }
        }
        return null;
    }
}
