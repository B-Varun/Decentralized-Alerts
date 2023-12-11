// SPDX-License-Identifier: GPL-3.0
// pragma solidity >=0.8.0 <=0.9.0;
pragma solidity >=0.5.16;
contract AlertManagement{

uint alert_Count=0;

enum Alert_Status{
    Open, 
    Closed
}

enum Alert_Type{
    Fire_Alert,
    Theft_Alert,
    Health_Emergency_Alert
}

struct Alert{
    uint alertID;
    string description;
    string title;
    string recipient_addrress;
    Alert_Type type_Of_Alert;
    Alert_Status status;
    address responder_address;
}

event AlertCreated(uint alertId);
// event AlertHandeled(uint alertId);

mapping(uint => Alert) public alerts;

function getAlert_Close_Status() public pure returns(Alert_Status){
    return Alert_Status.Closed;
}

function close_Alert_By_Responder(uint alertId, address responderAddr) public returns(Alert_Status){
    require(alertId<=alert_Count, "Alert with the mentioned ID is not registered");
    alerts[alertId-1].status = getAlert_Close_Status();
    alerts[alertId-1].responder_address = responderAddr;
    // if(alerts[alertId-1].status == Alert_Status.Closed){
    //     emit AlertHandeled(alertId);
    // }
    return alerts[alertId].status;
}


// function close_Alert_By_Responder_By_Addr(string memory addr, address responderAddr) public returns(Alert_Status){
//     require(bytes(addr).length !=0, "Address should not be empty");
//     alerts[alertId-1].status = getAlert_Close_Status();
//     alerts[alertId-1].responder_address = responderAddr;
//     // if(alerts[alertId-1].status == Alert_Status.Closed){
//     //     emit AlertHandeled(alertId);
//     // }
//     return alerts[alertId].status;
// }

function getAlert(uint id) public view returns(string memory){
    return alerts[id].title;
}

function get_AlertType_from_string(string memory alertType) private view returns(Alert_Type){
    if( keccak256(abi.encodePacked((alertType))) == keccak256(abi.encodePacked(("Fire"))) )
        return Alert_Type.Fire_Alert;
    else if( keccak256(abi.encodePacked((alertType))) == keccak256(abi.encodePacked(("Health"))) )
        return Alert_Type.Health_Emergency_Alert;
    if( keccak256(abi.encodePacked((alertType))) == keccak256(abi.encodePacked(("Theft"))) )
        return Alert_Type.Theft_Alert;        
}

function setAlert(uint id, string memory title, string memory desc, Alert_Type alertType, string memory recipientAddr) private{
    require(id>0);
    alerts[id-1] = Alert(
        {
            alertID:id, 
            title:title, 
            description:desc, 
            status: Alert_Status.Open, 
            type_Of_Alert:alertType,
            recipient_addrress: recipientAddr,
            responder_address : address(0)
        });
    emit AlertCreated(id);
}

function createAlert(string memory title, string memory description, string memory alertType, string memory recipientAddr) public returns(uint){
    alert_Count++;
    setAlert(alert_Count, title, description, get_AlertType_from_string(alertType), recipientAddr);
    return alert_Count;
}

}