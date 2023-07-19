function submit() {
    const username = document.getElementById('username').value;

    axios.post(`/member/temp-password/?id=${username}`)
        .then((res) => {
            console.log(res);
            if(res.data === true) {
                alert("이메일이 전송되었습니다.");
            } else {
                alert("잘못된 요청입니다. 입력하신 아이디를 확인해주세요.")
            }

        }).catch((err) => {
        if(err.response.status === 400) {
            alert("잘못된 아이디 입니다.");
        }
    })
}
