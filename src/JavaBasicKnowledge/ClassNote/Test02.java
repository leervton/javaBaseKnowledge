package JavaBasicKnowledge.ClassNote;

public class Test02 {
    MyTime t1 = new MyTime(2008,5,6);
    MyTime t2 = new MyTime(2008,5,6);
    Boolean b = t2.equals(t2);
}
class MyTime {
    int year;
    int month;
    int day;

    public MyTime() {
    }

    public MyTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * 判断条件：【先对内存地址进行比较，再比较内容】
     *          第一，判断内存地址是否相同，内存地址相同的话，直接是同一个对象
     *          第二，是否有继承关系，没有继承关系则输出false
     *          第三，是否为null
     * 以上判断条件是对内存地址进行比较
                                    equals方法重写的三种方式
    //--------------------------------------------------------------------------------------------

    public boolean equals(Object o){
        //内容比较
        //获取第一个年月日
        int year1 = year;
        int month1 = month;
        int day1 = day;
        //获取第二个年月日
        if(o instanceof MyTime){
            MyTime m =(MyTime)o;
            int day2 = m.day;
            int month2 = m.month;
            int year2 = m.year;
            if(year1 == year2&&month1 ==month2&& day1 == day2){
                return true;
            }
        }
        return false;
    }

    //--------------------------------------------------------------------------------------------

    public boolean equals(Object o){
        if(o == null||!(o instanceof MyTime)){
            return false;
        }
        if(this == o){
            return true;
        }
        MyTime m =(MyTime)o;
        if(this.day == m.day&&month == m.month&&year == m.year){
            return true;
        }
        return false;
    }
     */
    //---------------------------------------------------------------------------------------------
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTime)) return false;
        MyTime myTime = (MyTime) o;
        return year == myTime.year &&
                month == myTime.month &&
                day == myTime.day;
    }
}
