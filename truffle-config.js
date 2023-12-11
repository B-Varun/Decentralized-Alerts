const HDWalletProvider = require("@truffle/hdwallet-provider");
const mnemonic =
  "usage gentle hood satisfy reform gesture future bird embark eight harbor wood";

// `wss://eth-goerli.g.alchemy.com/v2/${alchemyKey}`
// `https://eth-goerli.alchemyapi.io/v2/${alchemyKey}`

module.exports = {
  networks: {
    goerli: {
      provider: () =>
        new HDWalletProvider(
          mnemonic,
          `https://goerli.infura.io/v3/ae1a7890f405484888b9e287a805903e`
          // `https://eth-goerli.g.alchemy.com/v2/U-JlHIJeEXhYqp1H_cAu4ygu7ZvvRojI`
        ),
      network_id: 5, // Goerli's network ID
      gas: 5500000, // Gas limit
      // gasPrice: 1, // Gas price (adjust as needed)
      confirmations: 2, // Number of confirmations before a tx is considered mined
      timeoutBlocks: 200, // Timeout for transactions to be mined
      skipDryRun: true, // Skip dry run before migrations? (optional for Goerli)
    },
    develop: {
      port: 8545,
    },
  },
};

// Old config start from here. This is working with Ganache
// module.exports = {
//   // See <http://truffleframework.com/docs/advanced/configuration>
//   // for more about customizing your Truffle configuration!
//   networks: {
//     development: {
//       host: "127.0.0.1",
//       port: 7545,
//       network_id: "*", // Match any network id
//     },
//     develop: {
//       port: 8545,
//     },
//   },
// };
