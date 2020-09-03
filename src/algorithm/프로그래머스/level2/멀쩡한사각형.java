package algorithm.프로그래머스.level2;

class 멀쩡한사각형 {
    public long solution(long w, long h) {
        long answer = 1;
        long  big =0,small=0;
        if(w>h) {
            big = w;
            small=h;
        } else {
            big = h;
            small = w;
        }
        
        while(small!=0) {
            long temp = big%small;
            big = small;
            small = temp;
            System.out.println("small = "+small);
        }
        
        answer = (w*h)-(w+h-big);

        return answer;
    }
}
