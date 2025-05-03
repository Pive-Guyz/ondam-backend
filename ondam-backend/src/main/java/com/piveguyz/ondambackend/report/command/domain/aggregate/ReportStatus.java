package com.piveguyz.ondambackend.report.command.domain.aggregate;

import lombok.Getter;

@Getter
public enum ReportStatus {
	PENDING(0),
	APPROVED(1),
	REJECTED(2);

	private final int value;

	ReportStatus(int value) {
		this.value = value;
	}

	public static ReportStatus fromValue(int value) {
		for (ReportStatus status : ReportStatus.values()) {
			if (status.getValue() == value) {
				return status;
			}
		}
		throw new IllegalArgumentException("알 수 없는 상태입니다: " + value);
	}
}