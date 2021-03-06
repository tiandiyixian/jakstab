/*
 * Harness.java - This file is part of the Jakstab project.
 * Copyright 2007-2015 Johannes Kinder <jk@jakstab.org>
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, see <http://www.gnu.org/licenses/>.
 */
package org.jakstab.loader;

import org.jakstab.Program;
import org.jakstab.asm.AbsoluteAddress;


/**
 * A harness that provides some code for calling the entry point of an executable and a 
 * safe final return destination with an explicit halt instruction.   
 */
public interface Harness {

	public static final long PROLOGUE_BASE = 0xface0000L;
	public static final long EPILOGUE_BASE = 0xfee70000L;
	public static final AbsoluteAddress prologueAddress = new AbsoluteAddress(PROLOGUE_BASE);
	public static final AbsoluteAddress epilogueAddress = new AbsoluteAddress(EPILOGUE_BASE);

	public void install(Program program);
	
	public boolean contains(AbsoluteAddress a);
	
	public AbsoluteAddress getFallthroughAddress(AbsoluteAddress a);

}
