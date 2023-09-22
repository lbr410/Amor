<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/amor/basepage/views/admin_main.css">
<body>
<div class="top">
	<div class="logo"><a href="#"></a><img src="img/logo.png"></div>
	<div class="logout"><input type="button" value="로그아웃"></div>
</div>
<div class="sideDiv">
	<div class="side">
		<div class="sidemenu">
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-1">회원 관리</a></div>
			</div>
			<div class="submenu" id="submenu-1"> 
				<div class="menutext" ><a href="#" data-submenu="submenu-1">회원 조회</a></div>
				<div class="menutext"><a href="#">회원 예매 목록</a></div>
			</div>
			
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-2">상영관 관리</a></div>
			</div>
			<div class="submenu" id="submenu-2"> 
				<div class="menutext"><a href="#">상영관 등록</a></div>
				<div class="menutext"><a href="#">상영영화 목록</a></div>
				<div class="menutext"><a href="#">상영시간 등록</a></div>
			</div>
			
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-3">영화 관리</a></div>
			</div>
			<div class="submenu" id="submenu-3"> 
				<div class="menutext"><a href="#">영화 목록</a></div>
				<div class="menutext"><a href="#">영화 등록</a></div>
			</div>
			
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-4">배너 관리</a></div>
			</div>	
			<div class="submenu" id="submenu-4"> 
				<div class="menutext"><a href="#">배너 목록</a></div>
				<div class="menutext"><a href="#">배너 등록</a></div>
			</div>			
			
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-5">관람평 관리</a></div>
			</div>
			<div class="submenu" id="submenu-5"> 
				<div class="menutext"><a href="faq.jsp">관람평 목록</a></div>
			</div>		
			
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-6">1:1문의 관리</a></div>
			</div>
			<div class="submenu" id="submenu-6"> 
				<div class="menutext"><a href="faq.jsp">관람평 목록</a></div>
			</div>	
						
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-7">공지 / FAQ 관리</a></div>
			</div>	
			<div class="submenu" id="submenu-7"> 
				<div class="menutext"><a href="#">공지사항 목록</a></div>
				<div class="menutext"><a href="#">공지사항 등록</a></div>
				<div class="menutext"><a href="#">FAQ 목록</a></div>
				<div class="menutext"><a href="#">FAQ 등록</a></div>
			</div>
			
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-8">매출 관리</a></div>
			</div>
			<div class="submenu" id="submenu-8"> 
				<div class="menutext"><a href="faq.jsp">관람평 목록</a></div>
			</div>	
			
			<div class="menu" onclick="toggleSubmenu(this)">
				<div class="menutext"><a href="#" data-submenu="submenu-9">스토어</a></div>
			</div>
			<div class="submenu" id="submenu-9"> 
				<div class="menutext"><a href="#">재고 목록</a></div>
				<div class="menutext"><a href="#">재고 등록</a></div>
				<div class="menutext"><a href="#">판매상품 목록</a></div>
				<div class="menutext"><a href="#">판매상품 등록</a></div>
				<div class="menutext"><a href="#">결제내역 관리</a></div>
			</div>			
		</div>
		
<script>
window.addEventListener('DOMContentLoaded', function () {

    var currentPage = window.location.href;

    var menuItems = document.querySelectorAll('.menu');

    var selectedMenu = localStorage.getItem('selectedMenu');
    var selectedSubmenu = localStorage.getItem('selectedSubmenu');

    menuItems.forEach(function (menuItem) {
        var link = menuItem.querySelector('a');
        var submenuId = link.getAttribute('data-submenu');
        var submenu = document.getElementById(submenuId);

        if (link.getAttribute('href') === currentPage || submenuId === selectedSubmenu) {
            menuItem.classList.add('selected');
            submenu.style.display = 'block';
        }
    });
});


function toggleSubmenu(menu) {
    var submenuId = menu.querySelector('a').getAttribute('data-submenu');
    var submenu = document.getElementById(submenuId);


    var allSubmenus = document.querySelectorAll('.submenu');
    allSubmenus.forEach(function (sub) {
        if (sub !== submenu) {
            sub.style.display = 'none';
        }
    });


    var allMenus = document.querySelectorAll('.menu');
    allMenus.forEach(function (item) {
        item.classList.remove('selected');
    });

    menu.classList.add('selected');

    if (submenu.style.display === 'block') {
        submenu.style.display = 'none';
        menu.classList.remove('selected'); 
    } else {
        submenu.style.display = 'block';
    }


    localStorage.setItem('selectedMenu', submenuId);
    localStorage.setItem('selectedSubmenu', submenuId);
}
</script>			
	</div>
</div>

</body>
</html>