# PHUONGDUC

API CREATE-USER
URL POST : http://103.130.213.182:8080/create-user
Body: Form-data 
--key : fileData , value : file image
--key : name , value : input data
--key : pass , value : input data
--key : email , value : input data
--key : adress , value : input data
--key : phone , value : input data


API Login
URL POST : http://103.130.213.182:8080/login
Body:
  {
    "name":"input data",
    "pass":"input data"
  }
  

API UPDATE-USER
URL PUT : http://103.130.213.182:8080/update-user/{id}
Headers :
--key : Authorization , value : get token on successful login
Body : 
  {
    "name": "input data",
    "adress" : "input data",
    "email":"input data",
    "phone":"input data",
    "pass":"input data"
    
  }


API UPDATE-USER-FILE
URL PUT : http://103.130.213.182:8080/update-user-file/{id}
Headers :
--key : Authorization , value : get token on successful login
Body: Form-data 
--key : fileData , value : file image


API USER-DETAIL
URL GET : http://103.130.213.182:8080/user-detail/{id}
Headers :
--key : Authorization , value : get token on successful login

API USER-LIST
URL GET : http://103.130.213.182:8080/user-list/{page}
Headers :
--key : Authorization , value : get token on successful login
NOTE : page starts at 0


API DELETE-USER
URL DELETE : http://103.130.213.182:8080/delete-user/{id}
Headers :
--key : Authorization , value : get token on successful login






















  
