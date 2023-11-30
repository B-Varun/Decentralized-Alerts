import "../App.css";
import { GiBoltSpellCast } from "react-icons/gi";

function Header({ connect, account }) {
  return (
    <div className="header">
      {/* <GiBoltSpellCast className="headerIcon" /> */}
      {/* {account == "" ? (
        <button onClick={connect} className="button">
          Connect
        </button>
      ) : (
        // <p>...{account.substring(account.length - 7)}</p>
        <h3>Account Address : {account}</h3>
      )} */}
      <h3>Account Address : {account}</h3>
    </div>
  );
}

export default Header;
