package ru.edu.project.backend.api.solutions;


import ru.edu.project.backend.api.common.AcceptorArgument;

import java.util.List;

public interface SolutionService {

    /**
     * Getting student's solutions.
     *
     * @param studentId
     * @return list of solutions
     */
    List<SolutionInfo> getSolutionsByStudent(long studentId);

    /**
     * Getting student's solution by task id.
     *
     * @param studentId
     * @param taskId
     * @return list of solutions
     */
    SolutionInfo getSolutionByStudentAndTask(long studentId, long taskId);

    /**
     * Getting solution info.
     *
     * @param solutionId
     * @return info
     */
    SolutionInfo getDetailedInfo(long solutionId);

    /**
     * Creating new solution.
     *
     * @param studentId
     * @param taskId
     * @return solutionInfo
     */
    SolutionInfo takeToWork(long studentId, long taskId);

    /** Uploading text of solution.
     *
     * @param solutionForm
     * @return solutionInfo
     */
    @AcceptorArgument
    SolutionInfo uploadSolution(SolutionForm solutionForm);

    /** Taking solution for review.
     *
     * @param solutionId
     * @return SolutionInfo
     */
    SolutionInfo takeForReview(long solutionId);

    /** Solution is verified.
     *
     * @param solutionReviewForm
     * @return SolutionInfo
     */
    @AcceptorArgument
    SolutionInfo verify(SolutionReviewForm solutionReviewForm);

    /**
     * Getting solutions by task id.
     *
     * @param taskId
     * @return list of solutions
     */
    List<SolutionInfo> getSolutionsByTask(long taskId);
}
