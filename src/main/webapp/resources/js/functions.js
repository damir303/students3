function deleteStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одного студента!!!")
        return;
    }


    // "1 2 5 7" - string
    debugger;
    var ids = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids = ids.substring(0, ids.length - 1);


    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();
}

function modificationStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0 || checkedCheckboxs.length > 1){
        alert("Выберите одного студента!!!")
        return;
    }
    var id = checkedCheckboxs[0].value

    document.getElementById("modificationStudentHidden").value = id;
    document.getElementById('modificationStudentForm').submit();
}