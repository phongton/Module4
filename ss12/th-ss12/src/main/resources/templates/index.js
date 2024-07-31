function addNewSmartPhone() {
    let producer=$('#producer').val();
    let model=$('#model').val();
    let price=$('#price').val()
    let newSmartPhone ={
        producer:producer,
        model:model,
        price:price
    };
    $.ajax({
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type:"POST",
        data: JSON.stringify(newSmartphone),
        //tên API
        url: "http://localhost:8080/api/smartphones",
        //xử lý khi thành công
        success: console.log("success")
    });
    event.preventDefault();

}