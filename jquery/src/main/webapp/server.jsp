<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

 <% 
        String searchInput = request.getParameter("searchInput"); 	//검색어 가져오기
        String searchType = request.getParameter("searchType"); 	//검색 조건 가져오기
        ResultSet rs = null;	//검색 결과를 저장할 ResultSet 객체를 초기화

        //DB연결
        try {
            String url="jdbc:sqlserver://211.224.106.226:1433;databaseName=UwayTalk;user=sa;password=unadmin;" ; 
            Connection c = DriverManager.getConnection(url);	//데이터베이스에 연결

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 검색 쿼리 작성
            String sql = "SELECT * FROM KIMDONGHEE_TEST WHERE " +searchType + "=?";
            
            PreparedStatement pstmt = c.prepareStatement(sql);
            pstmt.setString(1,searchInput);
            
            //검색 결과 가져오기
            rs = pstmt.executeQuery();
            
            //검색 결과 처리
            StringBuilder sb = new StringBuilder();
            sb.append("<table>");
            sb.append("<tr><th>empcode</th><th>empname</th><th>job</th><th>sal</th></tr>");
            int sum = 0;
            while (rs.next()) {
            	
            	sb.append("<tr>");
            	sb.append("<td>").append(rs.getString("empcode")).append("</td>");
            	sb.append("<td>").append(rs.getString("empname")).append("</td>");
            	sb.append("<td>").append(rs.getString("job")).append("</td>");
            	sb.append("<td>").append(rs.getString("sal")).append("</td>");
            	sum += rs.getInt("sal");
            	sb.append("</tr>");
            }
            
            sb.append("</table>");
            sb.append("<div>sal의 합계 : ").append(sum).append("</div>");
             	
            //response.setContentType("application/json");		// 응답내용의 MIME 타입을 application/json 으로 설정
            //response.setCharacterEncoding("UTF-8");		//응답 내용의 인코딩을 UTF-8로 설정
            //response.getWriter().write(json);		//JSON 형식의 문자열을 응답으로 보내기
            
            //table 구조 만들기
            
            out.print(sb.toString());	//StringBuilder 객체의 내용을 JSON 형식의 문자열로 변환
            rs.close();
            pstmt.close();
            
            
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
        
    %>
    