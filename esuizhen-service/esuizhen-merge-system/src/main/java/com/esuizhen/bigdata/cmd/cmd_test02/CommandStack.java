package com.esuizhen.bigdata.cmd.cmd_test02;

import java.util.ArrayList;
import java.util.List;

public class CommandStack {

	/**
     * Implement for each individual change that can occur in an editor.
	 * 

	 * Both {@link #execute()} and {@link #undo()} should fire property change
	 * events for notifying the editor of an update.
	 */
	public static abstract class Command {

		private String name;

		public Command(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

		/**
		 * Implements the actual change.
		 * 

		 * Any state-saving for {@link #undo()}
		 * has to occur elsewhere, eg. in the constructor.
		 */
		public abstract void execute();

		/**
		 * Reverts any changes applied by {@link #execute()}.
		 */
		public abstract void undo();

	}

	private final List<Command> commands = new ArrayList<>();
	//private final List commands = new ArrayList();
	private int currentLocation = -1;
	private int saveLocation = currentLocation; //保存当前状态

	/**
	 * 执行命令
	 * 加入队列
	 * 记录下传入命令服务的位置
	 * @param command
	 */
	public void add(Command command) {
		clearInFrontOfCurrent();
		command.execute();
		commands.add(command);
		currentLocation++;
	}

	/**
	 * 执行回退命令
	 * 位置状态回退
	 */
	public void undo() {
		commands.get(currentLocation).undo();
		currentLocation--;
	}

	/**
	 * 判断是否可以回退
	 * @return
	 */
	public boolean undoEnabled() {
		return currentLocation >= 0;
	}

	/**
	 * 重新执行
	 */
	public void redo() {
		currentLocation++;
		commands.get(currentLocation).execute();
	}

	/**
	 * 判断是否可以重新执行
	 * @return
	 */
	public boolean redoEnabled() {
		return currentLocation < commands.size() - 1;
	}

	/**
	 * 判断数据是否已经变化
	 * @return
	 */
	public boolean dirty() {
		return currentLocation != saveLocation;
	}

	/**
	 * 清空
	 */
	private void clearInFrontOfCurrent() {
		while (currentLocation < commands.size() - 1) {
			commands.remove(currentLocation + 1);
		}
	}

	/**
	 * 标记保存点
	 */
	public void markSaveLocation() {
		saveLocation = currentLocation;
	}

	@Override
	public String toString() {
		return commands.toString();
	}

}