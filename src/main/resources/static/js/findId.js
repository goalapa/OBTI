function submit() {
    const email = document.getElementById('email').value;

    let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
    if(!regex.test(email)) {
        alert('이메일 형식이 일치하지 않습니다.');
        return false;
    }

    axios.get(`/member/id/${email}`)
        .then((res) => {
            alert("이메일을 확인해주세요.");
        }).catch((err) => {
            if(err.response.status === 400) {
                alert("잘못된 이메일 입니다.");
            }
        })
}
