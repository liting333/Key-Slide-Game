package instruction;

import utilities.GameLog;

import java.util.Random;

/**
 * A developer-friendly wrapper of an instruction.
 * Allows generation of the next instruction state, provides access to the instruction instance,
 * gets the status of the current instruction, and can define a "reversed" state to allow for
 * reverse input images.
 *
 * TODO: Add more instructions?
 * 	- Rewind: Perform the last instruction
 * 	- Stop: Let the timer run out.
 *
 *
 * @author heshamsalman
 */
public class InstructionController {
	private static Instruction instr;
	private static final InstructionController instance = new InstructionController();
	boolean reverse = false;
	Random r = new Random();

	private InstructionController() {
		InstructionStatus p = InstructionStatus.getRandomStatus();
		instr = new Instruction(p);
	}

	public static synchronized InstructionController getInstance() {
		return instance;
	}

	public InstructionStatus getStatus() {
		return instr.getStatus();
	}

	public boolean isReversed() {
		reverse = r.nextBoolean();
		return reverse;
	}

	/**
	 * Generates next instruction by switching the instruction state.
	 */
	public void nextInstruction() {
		GameLog.log.entering(getClass().getName(), "nextInstruction");
		InstructionStatus p = InstructionStatus.getRandomStatus();
		instr.setStatus(p);
		if (p == InstructionStatus.STOP)
			reverse = false;
		else
			reverse = r.nextBoolean();
		GameLog.log.exiting(getClass().getName(), "nextInstruction");
	}
}
