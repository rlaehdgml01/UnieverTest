<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

 <% 
        String searchInput = request.getParameter("searchInput"); //검색어 가져오기
        String searchType = request.getParameter("searchType"); //검색 조건 가져오기
        
        ResultSet rs = null; //검색 결과를 저장할 ResultSet 객체를 초기화

        //DB연결
        try {
            String url="jdbc:sqlserver://211.224.106.226:1433;databaseName=UwayTalk;user=sa;password=unadmin;" ; 
            Connection c = DriverManager.getConnection(url);	//데이터베이스에 연결

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 검색 쿼리 작성
            String sql="";
            if(searchType.equals("all")){
            	sql = "SELECT empcode, empname, job, sal FROM KIMDONGHEE_TEST WHERE empcode = "  +searchInput+
            			" OR empname = '" + searchInput +
            			"' OR job = '" + searchInput +
            			"' OR sal = " + searchInput;
            }
            else{
            	sql = "SELECT empcode, empname, job, sal FROM KIMDONGHEE_TEST WHERE " +searchType + "= '" + searchInput +"'";
            }
            
            PreparedStatement pstmt = c.prepareStatement(sql);
            
            
            //검색 결과 가져오기
            rs = pstmt.executeQuery();
            
            //검색 결과 처리
            StringBuilder sb = new StringBuilder();
            sb.append("[");	//배열 형식
            boolean isFirst = true;
            while (rs.next()) {
            	if(!isFirst) {			//isFirst가 false 이면
            		sb.append(","); 	//배열의 두번째 요소부터는 ","가 붙는다
            	}
            	isFirst = false;
            	
            	sb.append("{");
            	sb.append("\"empcode\":\"").append(rs.getString("empcode")).append("\",");
            	sb.append("\"empname\":\"").append(rs.getString("empname")).append("\",");
            	sb.append("\"job\":\"").append(rs.getString("job")).append("\",");
            	sb.append("\"sal\":\"").append(rs.getString("sal")).append("\"");
            	sb.append("}");
            }
            
            sb.append("]");
            
            String json = sb.toString(); 	//StringBuilder 객체의 내용을 JSON 형식의 문자열로 변환
            out.print(json);
            rs.close();
            pstmt.close();
            c.close();
            
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
        
    %>
    