/*

Copyright 2016 The MITRE Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

This project contains content developed by The MITRE Corporation. If this 
code is used in a deployment or embedded within another project, it is 
requested that you send an email to opensource@mitre.org in order to let 
us know where this software is being used.

 */

package org.mitre.secretsharing.codec;

import java.util.NoSuchElementException;

/**
 * {@link ByteIterator} that iterates over the bytes in an array
 * @author Robin Kirkman
 *
 */
public class ArrayByteIterator implements ByteIterator {

	/**
	 * The array of bytes over which to iterate
	 */
	protected byte[] data;
	/**
	 * The current position in the array
	 */
	protected int pos;
	/**
	 * The end position in the array
	 */
	protected int stop;
	
	/**
	 * Create a new {@link ArrayByteIterator} using an argument {@code byte[]}, a starting
	 * position within that array, and a stopping position within that array.
	 * @param data The {@code byte} data to iterate over
	 * @param start The starting position
	 * @param stop The stopping position
	 */
	public ArrayByteIterator(byte[] data, int start, int stop) {
		this.data = data;
		this.pos = start;
		this.stop = stop;
	}

	@Override
	public boolean hasNext() {
		return pos < stop;
	}

	@Override
	public byte next() {
		if(!hasNext())
			throw new NoSuchElementException();
		return data[pos++];
	}

}
