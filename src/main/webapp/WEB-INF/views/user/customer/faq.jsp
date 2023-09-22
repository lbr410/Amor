<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/user/faq.css">
</head>
<body>
    <!-- GRAY NAVIGATE BAR -->
    <div class="gray-bar">
        <div class="location">
            <a href="#" title="페이지로 이동">고객센터</a>
            <a href="#" title="FAQ 페이지로 이동">FAQ</a>
        </div>
    </div>
    <div class="body-inner">
        <!-- BORDER BAR -->
        <div class="border-bar">
            <div class="border-title">FAQ</div>
        </div>
        <!-- CATEGORY BAR -->
        <div id="category-bar">
            <button class="category-button" id="active-category-button">
                <div>FAQ</div>
            </button>
            <button class="category-button">
                <div>공지사항</div>
            </button>
        </div>
        <form name="faq" class="faq">
            <table width="1100">
                <thead>
                    <tr>
                        <th>구분</th>
                        <th>질문</th>
                    </tr>
                </thead>
                <tfoot>

                </tfoot>
                <tbody>
                    <tr>
                        <td class="faq_type">구분</td>
                        <td class="faq_subject">제목</td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
<script>
    document.querySelectorAll('.category-button').forEach(button => {
      button.addEventListener("click", event => {
        document.querySelector("#active-category-button").removeAttribute('id')
  
        button.setAttribute('id', 'active-category-button')
      })
    })
  </script>
</body>
</html>