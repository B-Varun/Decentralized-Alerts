// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.5.16;

import "truffle/Assert.sol";
import "truffle/DeployedAddresses.sol";
import "../contracts/AlertManagement.sol";
import "truffle/console.sol";

contract TestAlerts{

AlertManagement alerts = AlertManagement(DeployedAddresses.AlertManagement());


function testCreateAlert() public{
string memory title = "1st Alert";
string memory description = "this is the description for the 1st Alert";
address expectedAlerter = address(this);

uint alertId = alerts.createAlert(title, description);
console.log(alertId);
Assert.equal(alertId, 1, "1st Alert should have the alertId as 1");
}

}