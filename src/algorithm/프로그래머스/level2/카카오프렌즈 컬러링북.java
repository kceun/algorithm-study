package algorithm.프로그래머스.level2;

import java.util.*;

class 카카오프렌즈컬러링북 {
    public static int numberOfArea = 0;
    public static int N=0,M=0,maxSizeOfOneArea = 0;
    public static int cnt = 0;
    public static boolean[][] visit;
    public static int[][] map;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};  
  public int[] solution(int m, int n, int[][] picture) {

      numberOfArea = 0;
      maxSizeOfOneArea =0;
      visit = new boolean[m][n];
      map = picture;
      N = n;
      M = m;
      
      for(int i = 0; i< picture.length; i++) {
          for(int j = 0; j<picture[0].length; j++) {
              
              cnt=0;
              
              if(picture[i][j]!=0 && !visit[i][j]) {
                  visit[i][j]=true;
                  dfs(i,j,picture[i][j]);
                  numberOfArea++;
              }
          }
      }
      
      
      
      int[] answer = new int[2];
      answer[0] = numberOfArea;//area.size();
      answer[1] = maxSizeOfOneArea;
     
      return answer;
  }
public static void dfs(int row,int col, int num) {
  
    
    cnt++;
    for(int i =0;i<4;i++) {
        
        int nx = row + dx[i];
        int ny = col + dy[i];
        
        //범위를 벗어나는가?
        if(nx >= M || nx < 0 || ny >= N || ny < 0)
            continue;
        //내가 찾는 영역이 아닌가?
        if(map[nx][ny]!=num)
            continue;
        //이미 들렸던 곳인가?
        if(visit[nx][ny])
            continue;
        
        visit[nx][ny]=true;
        dfs(nx,ny,num);
        
        
    }
    
    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,cnt);

}

}
