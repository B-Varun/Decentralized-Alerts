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
    // address recipient_addrress;
    // Alert_Type type_Of_Alert;
    Alert_Status status;
    // address responder_address;
}

event AlertCreated(uint alertId);

mapping(uint => Alert) public alerts;

function getAlert_Close_Status() public pure returns(Alert_Status){
    return Alert_Status.Closed;
}

function close_Alert_By_Responder(uint alertId) public returns(Alert_Status){
    require(alertId<=alert_Count, "Alert with the mentioned ID is not registered");
    alerts[alertId].status = getAlert_Close_Status();
    return alerts[alertId].status;
}

function getAlert(uint id) public view returns(string memory){
    return alerts[id].title;
}

function setAlert(uint id, string memory title, string memory desc) private{
    require(id>0);
    alerts[id-1] = Alert({alertID:id, title:title, description:desc, status: Alert_Status.Open});
    emit AlertCreated(id);
}

function createAlert(string memory title, string memory description) public returns(uint){
    alert_Count++;
    setAlert(alert_Count, title, description);
    return alert_Count;
}

}