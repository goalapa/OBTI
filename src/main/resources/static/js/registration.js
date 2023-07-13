async function chechId() {
    const id = document.getElementById('username').value;
    await axios.get(`/member/id/${id}`)
        .then((res) => {
            console.log(res);
            if(res.data === false) {
                alert('이미 사용중인 아이디 입니다.');
            }
        })
        .catch((err) => {

        })
}