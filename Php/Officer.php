
<?php
class Officer extends Person{
  private  $OID;
  private Area $area; 
  private $username;
  private $password;

function __construct($name,$id,$state,$phone,$username,$password,$area){
    $this->setName($name);
    $this->OID=$id;
    $this->setState($state);
    $this->setPhone($phone);
    $this->username=$username;
    $this->password=$password;
    $this->area=$area;
    

}
public function get_OID():int{
    return $this->OID;
}
    
public function get_area();Area{
    return $this->area;
}
   
    
public function set_area(){
       $this->area=$area;
    }
public function set_Username($username){
    $this->username=$username;
}
public function get_Username():String{
    return $this->username;
}
public function set_Password($password){
    $this->password=$password;
}
public function get_Password():String{
    return $this->password;
}
 public function getFamilyMembers():{
     
 }   
}
?>