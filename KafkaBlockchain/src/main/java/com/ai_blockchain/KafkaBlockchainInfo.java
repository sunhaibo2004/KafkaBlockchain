/**
 * KafkaBlockchainInfo.java
 *
 * Created on Jan 21, 2018, 5:48:50 PM
 *
 * Description: Contains the hash of the current chain tip and its serial number, for a given Kafka blockchain.
 *
 * Copyright (C) Jan 21, 2018 Stephen L. Reed.
 */
package com.ai_blockchain;

import java.util.Date;
import java.util.Objects;
import org.apache.log4j.Logger;

public class KafkaBlockchainInfo {

  // the logger
  private static final Logger LOGGER = Logger.getLogger(KafkaBlockchainInfo.class);
  // the blockchain name
  private final String blockchainName;
  // the hash of the current chain tip
  private final SHA256Hash sha256Hash;
  // the serial number
  private final long serialNbr;
  // the timestamp
  private final Date timestamp;

  /**
   * Constructs a new KafkaBlockchainInfo instance.
   *
   * @param blockchainName the blockchain name
   * @param sha256Hash the hash of the current chain tip
   * @param serialNbr the serial number
   */
  public KafkaBlockchainInfo(
          final String blockchainName,
          final SHA256Hash sha256Hash,
          final long serialNbr) {
    //Preconditions
    assert blockchainName != null && !blockchainName.isEmpty() : "kafkaIPAddress must be a non-empty string";
    assert sha256Hash != null : "sha256Hash must not be null";
    assert serialNbr >= 0 : "serialNbr must not be negative";

    this.blockchainName = blockchainName;
    this.sha256Hash = sha256Hash;
    this.serialNbr = serialNbr;
    timestamp = new Date();
  }

  /** Gets the blockchain name.
   *
   * @return the blockchain name
   */
  public String getBlockchainName() {
    return blockchainName;
  }

  /** Gets the hash of the current chain tip.
   *
   * @return the hash of the current chain tip
   */
  public SHA256Hash getSHA256Hash() {
    return sha256Hash;
  }

  /** Gets the serial number.
   *
   * @return the serial number
   */
  public long getSerialNbr() {
    return serialNbr;
  }

  /** Gets the timestamp.
   *
   * @return the timestamp
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Return a string representation of this object.
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    return new StringBuilder()
            .append("[KafkaBlockchainInfo ")
            .append(blockchainName)
            .append(", serial ")
            .append(serialNbr)
            .append(", hash")
            .append(sha256Hash)
            .append(", timestamp")
            .append(timestamp)
            .toString();
  }

  /**
   * Returns a hash code for this object.
   *
   * @return a hash code for this object
   */
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.sha256Hash);
    hash = 53 * hash + (int) (this.serialNbr ^ (this.serialNbr >>> 32));
    return hash;
  }

  /**
   * Returns whether another object equals this one.
   *
   * @param obj the other object
   * @return whether another object equals this one
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final KafkaBlockchainInfo other = (KafkaBlockchainInfo) obj;
    if (this.serialNbr != other.serialNbr) {
      return false;
    }
    if (!Objects.equals(this.sha256Hash, other.sha256Hash)) {
      return false;
    }
    return true;
  }

}