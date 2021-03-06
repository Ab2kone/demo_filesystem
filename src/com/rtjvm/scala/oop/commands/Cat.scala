package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

/**
 * Created by aboubakar on 24-Oct-21.
 */
class Cat(filename: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd

    val dirEntry = wd.findEntry(filename)
    if (dirEntry == null || !dirEntry.isFile)
      state.setMessage(filename + ": no such file")
    else
      state.setMessage(dirEntry.asFile.contents)
  }
}
