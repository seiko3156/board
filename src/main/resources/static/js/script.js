/*게시글 검색*/

function go_search( comm ){
	if( document.frm.key.value == "" ){
		alert("검색버튼 사용시에는 검색어 입력이 필수입니다");
	 	return;
	}
	var url = comm;
	document.frm.action = url;
	document.frm.submit();
}
/*게시글 전체보기*/
function go_total( comm ){
	document.frm.key.value="";
	document.frm.action = comm + "?first=1";
	document.frm.submit();
}

/*직원삭제*/
function deletelist( num ){
	location.href="delete?num="+num;
}
/*직원수정폼 이동*/
function updatelist( num ){
	location.href="updateForm?num="+num;
}
/*직원등록*/
function writeAction(){
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	var patternPhone = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/;
	var patternEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(!patternPhone.test(phone)) {
	  document.writeForm.phone.focus();		
	  document.getElementById("checkBrnMessage").innerText ="전화번호 형식이 맞지 않습니다.(ex 010-1111-1111)";
	}else if(!patternEmail.test(email)){
	  document.writeForm.email.focus();		
	  document.getElementById("checkBrnMessage").innerText ="이메일 형식이 맞지 않습니다.(ex test@test.com)";
	}else{
	  document.writeForm.submit();
	}
	
}

/*직원수정*/
function updateAction(){
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	var patternPhone = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/;
	var patternEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(!patternPhone.test(phone)) {
	  document.updateForm.phone.focus();		
	  document.getElementById("checkBrnMessage").innerText ="전화번호 형식이 맞지 않습니다.(ex 010-1111-1111)";
	}else if(!patternEmail.test(email)){
	  document.updateForm.email.focus();		
	  document.getElementById("checkBrnMessage").innerText ="이메일 형식이 맞지 않습니다.(ex test@test.com)";
	}else{
	  document.updateForm.submit();
	}
	
}


