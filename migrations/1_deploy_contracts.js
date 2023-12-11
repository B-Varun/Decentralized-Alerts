var AlertManagement = artifacts.require("./AlertManagement.sol");
var Responder = artifacts.require("./Responder.sol");
module.exports = function (deployer) {
  // deployer.deploy(AlertManagement).then(function () {
  //   return deployer.deploy(Responder, AlertManagement.address);
  // });
  deployer.deploy(AlertManagement);
};
// var Alerts = artifact.require("AlertManagement");
// module.exports = function (deployer) {
//     deployer.deploy(Alerts);
// };
