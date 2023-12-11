// SPDX-License-Identifier: GPL-3.0
// pragma solidity >=0.8.0 <=0.9.0;
pragma solidity >=0.5.16;
import "./AlertManagement.sol";
contract Responder{
 AlertManagement public management;

 constructor(address _address) public{
    management = AlertManagement(_address);
 }

function handleAlert(uint alertId) public{
    management.close_Alert_By_Responder(alertId, address(this));
}

// function handleAlertByAddress(string memory addr) public{
//     management.close_Alert_By_Responder_By_Addr(addr, address(this));
// }

}