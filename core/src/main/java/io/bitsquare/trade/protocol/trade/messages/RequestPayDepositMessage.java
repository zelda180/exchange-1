/*
 * This file is part of Bitsquare.
 *
 * Bitsquare is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bitsquare is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bitsquare. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bitsquare.trade.protocol.trade.messages;

import io.bitsquare.fiat.FiatAccount;

import org.bitcoinj.core.TransactionOutput;

import java.io.Serializable;

import java.security.PublicKey;

import java.util.List;

import javax.annotation.concurrent.Immutable;

@Immutable
public class RequestPayDepositMessage extends TradeMessage implements Serializable {
    // That object is sent over the wire, so we need to take care of version compatibility.
    private static final long serialVersionUID = 1L;

    public final List<TransactionOutput> buyerConnectedOutputsForAllInputs;
    public final List<TransactionOutput> buyerOutputs;
    public final byte[] buyerTradeWalletPubKey;
    public final PublicKey buyerP2PSigPublicKey;
    public final PublicKey buyerP2PEncryptPublicKey;
    public final FiatAccount buyerFiatAccount;
    public final String buyerAccountId;

    public RequestPayDepositMessage(String tradeId,
                                    List<TransactionOutput> buyerConnectedOutputsForAllInputs,
                                    List<TransactionOutput> buyerOutputs,
                                    byte[] buyerTradeWalletPubKey,
                                    PublicKey buyerP2PSigPublicKey,
                                    PublicKey buyerP2PEncryptPublicKey,
                                    FiatAccount buyerFiatAccount,
                                    String buyerAccountId) {
        super(tradeId);
        this.buyerP2PSigPublicKey = buyerP2PSigPublicKey;
        this.buyerP2PEncryptPublicKey = buyerP2PEncryptPublicKey;
        this.buyerConnectedOutputsForAllInputs = buyerConnectedOutputsForAllInputs;
        this.buyerOutputs = buyerOutputs;
        this.buyerTradeWalletPubKey = buyerTradeWalletPubKey;
        this.buyerFiatAccount = buyerFiatAccount;
        this.buyerAccountId = buyerAccountId;
    }
}