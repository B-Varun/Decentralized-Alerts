package com.test.wrapper;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.0.
 */
@SuppressWarnings("rawtypes")
public class AlertManagement extends Contract {
    public static final String BINARY = "0x60806040526000805534801561001457600080fd5b50610f99806100246000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806305d2bc121461005c578063171d073a146100cc57806348ac10d5146102af57806373e8751514610543578063850818861461056f575b600080fd5b6100a86004803603604081101561007257600080fd5b8101908080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610616565b604051808260018111156100b857fe5b60ff16815260200191505060405180910390f35b6100f8600480360360208110156100e257600080fd5b8101908080359060200190929190505050610737565b6040518088815260200180602001806020018060200187600281111561011a57fe5b60ff16815260200186600181111561012e57fe5b60ff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184810384528a818151815260200191508051906020019080838360005b838110156101a0578082015181840152602081019050610185565b50505050905090810190601f1680156101cd5780820380516001836020036101000a031916815260200191505b50848103835289818151815260200191508051906020019080838360005b838110156102065780820151818401526020810190506101eb565b50505050905090810190601f1680156102335780820380516001836020036101000a031916815260200191505b50848103825288818151815260200191508051906020019080838360005b8381101561026c578082015181840152602081019050610251565b50505050905090810190601f1680156102995780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b61052d600480360360808110156102c557600080fd5b81019080803590602001906401000000008111156102e257600080fd5b8201836020820111156102f457600080fd5b8035906020019184600183028401116401000000008311171561031657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561037957600080fd5b82018360208201111561038b57600080fd5b803590602001918460018302840111640100000000831117156103ad57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561041057600080fd5b82018360208201111561042257600080fd5b8035906020019184600183028401116401000000008311171561044457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156104a757600080fd5b8201836020820111156104b957600080fd5b803590602001918460018302840111640100000000831117156104db57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929050505061097b565b6040518082815260200191505060405180910390f35b61054b6109b2565b6040518082600181111561055b57fe5b60ff16815260200191505060405180910390f35b61059b6004803603602081101561058557600080fd5b81019080803590602001909291905050506109bb565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105db5780820151818401526020810190506105c0565b50505050905090810190601f1680156106085780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60008054831115610672576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602d815260200180610f38602d913960400191505060405180910390fd5b61067a6109b2565b6001600060018603815260200190815260200160002060040160016101000a81548160ff021916908360018111156106ae57fe5b0217905550816001600060018603815260200190815260200160002060040160026101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506001600084815260200190815260200160002060040160019054906101000a900460ff16905092915050565b6001602052806000526040600020600091509050806000015490806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107e95780601f106107be576101008083540402835291602001916107e9565b820191906000526020600020905b8154815290600101906020018083116107cc57829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108875780601f1061085c57610100808354040283529160200191610887565b820191906000526020600020905b81548152906001019060200180831161086a57829003601f168201915b505050505090806003018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109255780601f106108fa57610100808354040283529160200191610925565b820191906000526020600020905b81548152906001019060200180831161090857829003601f168201915b5050505050908060040160009054906101000a900460ff16908060040160019054906101000a900460ff16908060040160029054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905087565b600080600081548092919060010191905055506109a5600054868661099f87610a73565b86610cd3565b6000549050949350505050565b60006001905090565b6060600160008381526020019081526020016000206002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a675780601f10610a3c57610100808354040283529160200191610a67565b820191906000526020600020905b815481529060010190602001808311610a4a57829003601f168201915b50505050509050919050565b600060405160200180807f4669726500000000000000000000000000000000000000000000000000000000815250600401905060405160208183030381529060405280519060200120826040516020018082805190602001908083835b60208310610af35780518252602082019150602081019050602083039250610ad0565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051602081830303815290604052805190602001201415610b3d5760009050610cce565b60405160200180807f4865616c74680000000000000000000000000000000000000000000000000000815250600601905060405160208183030381529060405280519060200120826040516020018082805190602001908083835b60208310610bbb5780518252602082019150602081019050602083039250610b98565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051602081830303815290604052805190602001201415610c055760029050610cce565b60405160200180807f5468656674000000000000000000000000000000000000000000000000000000815250600501905060405160208183030381529060405280519060200120826040516020018082805190602001908083835b60208310610c835780518252602082019150602081019050602083039250610c60565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051602081830303815290604052805190602001201415610ccd5760019050610cce565b5b919050565b60008511610ce057600080fd5b6040518060e00160405280868152602001848152602001858152602001828152602001836002811115610d0f57fe5b815260200160006001811115610d2157fe5b8152602001600073ffffffffffffffffffffffffffffffffffffffff1681525060016000600188038152602001908152602001600020600082015181600001556020820151816001019080519060200190610d7d929190610e92565b506040820151816002019080519060200190610d9a929190610e92565b506060820151816003019080519060200190610db7929190610e92565b5060808201518160040160006101000a81548160ff02191690836002811115610ddc57fe5b021790555060a08201518160040160016101000a81548160ff02191690836001811115610e0557fe5b021790555060c08201518160040160026101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055509050507feea119c2808a7787437044c26b843debbae8bf3964885ff18ff451681afee7d5856040518082815260200191505060405180910390a15050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610ed357805160ff1916838001178555610f01565b82800160010185558215610f01579182015b82811115610f00578251825591602001919060010190610ee5565b5b509050610f0e9190610f12565b5090565b610f3491905b80821115610f30576000816000905550600101610f18565b5090565b9056fe416c657274207769746820746865206d656e74696f6e6564204944206973206e6f742072656769737465726564a265627a7a72315820fd7b98ba1dd81926552087fa50ec779060c2bf9828bda96c1ff582215ee1917664736f6c63430005100032";

    public static final String FUNC_ALERTS = "alerts";

    public static final String FUNC_GETALERT_CLOSE_STATUS = "getAlert_Close_Status";

    public static final String FUNC_CLOSE_ALERT_BY_RESPONDER = "close_Alert_By_Responder";

    public static final String FUNC_GETALERT = "getAlert";

    public static final String FUNC_CREATEALERT = "createAlert";

    public static final Event ALERTCREATED_EVENT = new Event("AlertCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0x9c75288421298212E793aC3f2Fac86473C17341c");
    }

    @Deprecated
    protected AlertManagement(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AlertManagement(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AlertManagement(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AlertManagement(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<AlertCreatedEventResponse> getAlertCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ALERTCREATED_EVENT, transactionReceipt);
        ArrayList<AlertCreatedEventResponse> responses = new ArrayList<AlertCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AlertCreatedEventResponse typedResponse = new AlertCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.alertId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AlertCreatedEventResponse getAlertCreatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ALERTCREATED_EVENT, log);
        AlertCreatedEventResponse typedResponse = new AlertCreatedEventResponse();
        typedResponse.log = log;
        typedResponse.alertId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<AlertCreatedEventResponse> alertCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAlertCreatedEventFromLog(log));
    }

    public Flowable<AlertCreatedEventResponse> alertCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ALERTCREATED_EVENT));
        return alertCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple7<BigInteger, String, String, String, BigInteger, BigInteger, String>> alerts(BigInteger param0) {
        final Function function = new Function(FUNC_ALERTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple7<BigInteger, String, String, String, BigInteger, BigInteger, String>>(function,
                new Callable<Tuple7<BigInteger, String, String, String, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple7<BigInteger, String, String, String, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<BigInteger, String, String, String, BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getAlert_Close_Status() {
        final Function function = new Function(FUNC_GETALERT_CLOSE_STATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> close_Alert_By_Responder(BigInteger alertId, String responderAddr) {
        final Function function = new Function(
                FUNC_CLOSE_ALERT_BY_RESPONDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(alertId), 
                new org.web3j.abi.datatypes.Address(responderAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getAlert(BigInteger id) {
        final Function function = new Function(FUNC_GETALERT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createAlert(String title, String description, String alertType, String recipientAddr) {
        final Function function = new Function(
                FUNC_CREATEALERT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(title), 
                new org.web3j.abi.datatypes.Utf8String(description), 
                new org.web3j.abi.datatypes.Utf8String(alertType), 
                new org.web3j.abi.datatypes.Utf8String(recipientAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AlertManagement load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AlertManagement(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AlertManagement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AlertManagement(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AlertManagement load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AlertManagement(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AlertManagement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AlertManagement(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AlertManagement> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AlertManagement.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AlertManagement> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AlertManagement.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AlertManagement> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AlertManagement.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AlertManagement> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AlertManagement.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AlertCreatedEventResponse extends BaseEventResponse {
        public BigInteger alertId;
    }
}
