function submit() {
    const email = document.getElementById('email').value;

    let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
    if(!regex.test(email)) {
        alert('이메일 형식이 일치하지 않습니다.');
        return false;
    }

    axios.get(`/member/id/find-id/?email=${email}`)
        .then((res) => {
            console.log(res);
            if(res.data === true) {
                alert("이메일이 전송되었습니다.");
            } else {
                alert("잘못된 요청입니다. 입력하신 이메일을 확인해주세요.")
            }

        }).catch((err) => {
            if(err.response.status === 400) {
                alert("잘못된 이메일 입니다.");
            }
        })
}
