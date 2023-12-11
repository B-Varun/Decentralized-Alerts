import "./App.css";
import { ethers } from "ethers";
import { useState, useEffect } from "react";
import contractABI from "./abi/contractABI.json";
import Header from "./components/Header";

function App() {
  const [account, setAccount] = useState("");
  const [signer, setSigner] = useState(null);
  const [alerterContractInstance, setAlerterContractInstance] = useState(null);
  const [responderContractInstance, setResponderContractInstance] =
    useState(null);
  const [responderContract, setResponderContract] = useState(null);

  const listenToEvent = () => {
    console.log("Contract instance : ");
    console.log(alerterContractInstance);
    if (alerterContractInstance) {
      alerterContractInstance.on("AlertCreated", (alertId) => {
        console.log("ID of the alert is : " + alertId);
        if (responderContractInstance) {
          // Code to respond to events
          console.log("\n\nGot an event\n\n");
          responderContractInstance.handleAlert(alertId);
        } else {
          console.log("Responder instance not available");
        }
      });
    } else {
      console.log(
        "Alerter Contract instance not available for listening to events"
      );
    }
  };

  const listenToEventUsingAddress = (address) => {
    console.log("Contract instance : ");
    console.log(alerterContractInstance);
    if (alerterContractInstance) {
      if (responderContractInstance) {
        responderContractInstance.handleAlertByAddress(address);
      }
    } else {
      console.log(
        "Alerter Contract instance not available for listening to events"
      );
    }
  };

  const connect = async () => {
    // const myBlockchain_URL = "http://127.0.0.1:7545";
    const myBlockchain_URL = "http://127.0.0.1:7545";

    if (typeof window.ethereum !== "undefined") {
      const accounts = await window.ethereum.request({
        method: "eth_requestAccounts",
      });

      const provider = new ethers.providers.JsonRpcProvider(myBlockchain_URL);
      const signer = provider.getSigner();
      setSigner(signer);
      setAccount(accounts[0]);

      const alerterContractAddress =
        "0xd483db3ab0aa30185d068fa3cdf3d61224639a6f";
      const responderContractAddress =
        "0xd9890EC07951D905b462725e65113eD154b4f1Fe";
      const alerterContract = new ethers.Contract(
        alerterContractAddress,
        contractABI,
        signer
      );
      const responderContract = new ethers.Contract(
        responderContractAddress,
        contractABI,
        signer
      );
      setAlerterContractInstance(alerterContract);
      setResponderContractInstance(responderContract);

      console.log("account : " + accounts[0]);
      console.log(signer);
    } else {
      console.log("Please install metamask.");
    }
  };

  const createAlert = async () => {
    if (alerterContractInstance) {
      try {
        const title = "2nd Alert";
        const description = "Nuventi ra babu";
        const address = "6000 J Street, Sacramento, CA, USA, 95819";
        const transactionInstance = await alerterContractInstance.createAlert(
          title,
          description,
          "Fire",
          address
        );
        await transactionInstance.wait();
        console.log("Alert Created!");
        // listenToEventUsingAddress(address);
      } catch (error) {
        console.error("Error creating an alert", error);
      }
    } else {
      console.log("Contract instance not available");
    }
  };

  useEffect(() => {
    console.log("Connecting");
    connect();
    listenToEvent();
  }, []);

  return (
    <div className="page">
      <Header connect={connect} account={account} />
      <div className="main">
        <h1>Alerts</h1>
        <br />
        <button className="button" onClick={createAlert}>
          Create an Alert
        </button>
      </div>
    </div>
  );
}

export default App;
