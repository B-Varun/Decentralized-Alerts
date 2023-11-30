import "./App.css";
import { ethers } from "ethers";
import { useState, useEffect } from "react";
import contractABI from "./abi/contractABI.json";
import Header from "./components/Header";
// const Web3 = require("web3");
// const contractAbi = require("./abi/contractABI.json");

function App() {
  const [account, setAccount] = useState("");
  const [signer, setSigner] = useState(null);
  const [contractInstance, setContractInstance] = useState(null);

  // const balance = async (tokenAddress) => {
  //   const contract = new ethers.Contract(tokenAddress, contractABI, signer);
  //   const balance = await contract.balanceOf(account);
  //   console.log(balance.toString());
  // };

  const listenToEvent = () => {
    console.log("Contract instance : ");
    console.log(contractInstance);
    if (contractInstance) {
      contractInstance.on("AlertCreated", (owner, message) => {
        console.log("An alert is published whose owner is : " + owner);
        console.log("Message is : " + message);
      });
    } else {
      console.log("Contract instance not available for listening to events");
    }
  };

  const connect = async () => {
    const myBlockchain_URL = "http://127.0.0.1:7545";

    if (typeof window.ethereum !== "undefined") {
      const accounts = await window.ethereum.request({
        method: "eth_requestAccounts",
      });
      // const provider = new ethers.providers.Web3Provider(window.ethereum);
      const provider = new ethers.providers.JsonRpcProvider(myBlockchain_URL);
      const signer = provider.getSigner();
      setSigner(signer);
      setAccount(accounts[0]);

      const contractAddress = "0xeE701B5b228D088CB6c375d1f07ed6c58Be7b166";
      const contract = new ethers.Contract(
        contractAddress,
        contractABI,
        signer
      );
      setContractInstance(contract);

      console.log("account : " + accounts[0]);
      console.log(signer);
    } else {
      console.log("Please install metamask.");
    }
  };

  const createAlert = async () => {
    if (contractInstance) {
      try {
        const title = "2nd Alert";
        const description = "Nuventi ra babu";
        const transactionInstance = await contractInstance.createAlert(
          title,
          description
        );
        await transactionInstance.wait();
        console.log("Alert Created!");
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
